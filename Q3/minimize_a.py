import sys
class SimumlteniousEQ:
    def __init__(self):
        self.result = None

    def find_a_and_b_given_sum_and_xor_values(self, sum, xor): 
        """
        This method find values of a and b  minimizing value of a as possible
        """
        A = (sum - xor)//2
        a = 0
        b = 0

        # traversing thoughout the bits 
        for i in range(8): 
            # shifting the bits to the ith left
            Xi = (xor & (1 << i)) 
            Ai = (A & (1 << i)) 
            if (Xi == 0 and Ai == 0): 
                continue
                
            elif (Xi == 0 and Ai > 0): 
                a = ((1 << i) | a) 
                b = ((1 << i) | b) 
            
            elif (Xi > 0 and Ai == 0): 
                a = ((1 << i) | a) 
           

            else: 
                self.result = -1

        if a != b:
            if self.result is None:
                self.result = "{} {}".format(b,a)
        return self.result

    def get_sum_and_xor_from_user(self, str):
        """
        splits the user input
        """
        input_ = str.split(" ")
        if len(input_) != 2:
            print("the fromat is X Y eg 4 2, there is a space between the two values.")
            sys.exit()
        return input_
        
   
    @classmethod
    def display_result(cls, result_list):
        for i in result_list:
            print(i)

        # return statement is for testing purpose only
        return result_list

if __name__ == "__main__":
    result_list = []
    script_continue = True
    while script_continue:
        try:
            queries = int(input("Enter number of queries::"))
        except (NameError, ValueError):
            print("Wrong input, ensure query is digit:-) ")
            sys.exit()
        count = 1
        while count <= queries:
            sum_and_or_values_str = input("enter space separated values eg 4 2::")
            res = SimumlteniousEQ()
            input_ = res.get_sum_and_xor_from_user(sum_and_or_values_str)
            xor = input_[1]
            sum_ = input_[0]
            result = res.find_a_and_b_given_sum_and_xor_values(int(sum_), int(xor)) 
            result_list.append(result)
            count += 1
        else:
            script_continue = False

    SimumlteniousEQ.display_result(result_list)   
        
    


