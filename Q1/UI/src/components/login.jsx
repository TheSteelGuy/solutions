import React, { useState, useEffect } from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import Link from '@material-ui/core/Link';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
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
const SignIn = () => {
    const classes = useStyles();
    const [errors, setErrors] = useState(false);
    const [email, setEmail] = useState();
    const [password, setPassword] = useState();
    const [loading, setLoading] = useState(false)
    const [appError, setappError] = useState(false)
    const [message, setMessage] = useState()
    const [success, setSuccess] = useState()
    
    

    const login = async function (data) {
      const res = await fetch("http://localhost:8080/api/auth/login",{
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });
      res
        .json()
        .then(res => {
      
            if (res.error){setappError(true)}
            setMessage(res.message)
            setSuccess(res.success)
            setLoading(false)
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
          case 'email':
            setErrors({ [name]: validEmailRegex.test(value)? '': 'Email is not valid!'}) 
            setEmail(value);
            break;
          case 'password': 
          setErrors({[name]: value.length < 6 ? 'password must be more than 5 characters long' : ''}) 
          setPassword(value);
   

            break;
          default:
            break;
        }
     
      }
      const handleSubmit = (event) => {
          event.preventDefault();
          
          console.log(".......",loading)
          let loginDetails = {"email":email, 'password':password}
          login(loginDetails)
        
         
        
      }

    return (
        <Grid container component="main" className={classes.root}>
            <CssBaseline />
            <Grid item xs={false} sm={4} md={7} className={classes.image} />
            <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
             <div className={classes.paper}>
                <Avatar className={classes.avatar}>
                    <LockOutlinedIcon />
                </Avatar>
                <Typography component="h1" variant="h5">
                    Sign in                
                </Typography>
              
                    <form className={classes.form} onSubmit = {handleSubmit}>
                    {appError?<p style={pStyle}>{message}</p>:<p></p>}
                    {success?<p style={psuccessStyle}>{message}</p>:<p></p>}
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
                        <Button disabled={!(password && password.length>5 && email)}
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
                                <Link href="register" variant="body2">
                                    {"Don't have an account? Sign Up"}
                                </Link>
                            </Grid>
                        </Grid>
                    </form>
                </div>
            </Grid>
        </Grid>
    );
}
export default SignIn