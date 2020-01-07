import React, { useState } from 'react';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import Link from '@material-ui/core/Link';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import image from '../assets/image.PNG';



const useStyles = makeStyles(theme => ({
    root: {
        height: '100vh',
    },
    image: {
        backgroundImage: `url(${image})`,
        backgroundSize: 'cover',
        backgroundPosition: 'center',
    },
    paper: {
        margin: theme.spacing(8, 4),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
    avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },
    form: {
        marginTop: theme.spacing(1),
        width:'100%'
    },
    submit: {
        margin: theme.spacing(4, 0, 2),
        backgroundColor: 'green',
    },
}));

const pStyle = {
    color: 'red',
    width:'100%'
  };
const psuccessStyle = {
color: 'green',
width:'100%'
}
const SignUp = () => {
    const classes = useStyles();
    const [errors, setErrors] = useState(false);
    const [email, setEmail] = useState();
    const [name, setName] = useState();
    const [username, setUsername] = useState();
    const [confirm, setConfirm] = useState();
    const [password, setPassword] = useState();
    const [loading, setLoading] = useState(false)
    const [appError, setappError] = useState(false)
    const [message, setMessage] = useState()
    const [success, setSuccess] = useState()
    
    

    const signup = async function (data) {
      const res = await fetch("http://localhost:8080/api/auth/register",{
        method: 'POST', 
        cache: 'no-cache', 
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });
      res
        .json()
        .then(res => {
      
            if (res.error){setappError(true)}
            setLoading(false)
            setMessage(res.message)
            setSuccess(res.success)
        })

        .catch(err =>{
             setErrors(err)
             setLoading(false)
            });
    }

 

    let handleChange = (event) => {
        event.preventDefault();
        const { name, value } = event.target;
       
      
        const validEmailRegex =  RegExp(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i);
      
        switch (name) {
          case 'name': 
            setErrors({ [name]:value.length < 4? 'Name must be between 4 and 20 characters long!' : ''})
            setName(value);
            break;
            case 'username': 
            setErrors({ [name]: value.length < 4? 'Username must be between 4 and 20  characters long!': ''});
            setUsername(value);
            break;
          case 'email':
            setErrors({ [name]: validEmailRegex.test(value)? '': 'Email is not valid!'}) 
            setEmail(value);
            break;
          case 'password': 
          setErrors({[name]: value.length < 6 ? 'password must be more than 5 characters long' : ''}) 
          setPassword(value);
          break;
          case 'confirm': 
          setErrors({[name]:value=== password ? '': 'password mismatch'})
          setConfirm(value)
          break;
          default:
            break;
        }
     
      }
      const handleSubmit = (event) => {
          event.preventDefault();
          let signupDetails = {
            "fullName" : name,
            "username":username,
            "email" : email,
            "password" : password,
            
            }
          signup(signupDetails)
        
         
        
      }

    return (
        <Grid container component="main" className={classes.root}>
            <CssBaseline />
            <Grid item xs={false} sm={4} md={7} className={classes.image} />
            <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
             <div className={classes.paper}>

                <Typography component="h1" variant="h5">
                    Sign Up                
                </Typography>
              
                    <form className={classes.form} onSubmit = {handleSubmit}>
                    {!success?<p style={pStyle}>{message}</p>:<p></p>}
                    {success?<p style={psuccessStyle}>{message}</p>:<p></p>}
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="name"
                        label="Name"
                        name="name"
                        autoComplete="name"
                        autoFocus
                        onChange={handleChange}
                        />
                        <p style={pStyle}>{errors.name}</p>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="username"
                            label="Username"
                            name="username"
                            autoComplete="username"
                            autoFocus
                            onChange={handleChange}
                        />
                        <p style={pStyle}>{errors.username}</p>
                       
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="email"
                            label="Email Address"
                            name="email"
                            autoComplete="email"
                            autoFocus
                            onChange={handleChange}
                        />
                        <p style={pStyle}>{errors.email}</p>

                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            name="password"
                            label="Password"
                            type="password"
                            id="password"
                            autoComplete="current-password"
                            onChange={handleChange}
                        />
                        <p style={pStyle}>{errors.password}</p>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            name="confirm"
                            label="Confirm password"
                            type="password"
                            id="confirm"
                            autoComplete="confirm-password"
                            onChange={handleChange}
                        />
                        <p style={pStyle}>{errors.confirm}</p>
                        <Button disabled={
                            !(password && password.length>5 && email) ||
                            !(name && name.length>4)||
                            !(username && username.length > 4) ||
                            !(confirm && confirm===password)
                        }
                            type="submit"
                            fullWidth
                            variant="contained"
                            color="primary"
                            className={classes.submit}
                            onClick={()=>setLoading(true)}
                        >
                            {loading?'Please wait...':'Sign In'}
                        </Button>
                       
                        <Grid container>

                            <Grid item>
                                <Link href="login" variant="body2">
                                    {"Already't have an account? Sign In"}
                                </Link>
                            </Grid>
                        </Grid>
                    </form>
                </div>
            </Grid>
        </Grid>
    );
}
export default SignUp