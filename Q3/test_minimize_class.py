import unittest
from minimize_a import SimumlteniousEQ

class TestSimumlteniousEQ(unittest.TestCase):
    
    def test_find_a_and_b_given_sum_and_xor_values_works(self):
        minimize_a_obj = SimumlteniousEQ()
        self.assertEqual(minimize_a_obj.find_a_and_b_given_sum_and_xor_values(4, 2), "1 3","a=1 b=3")

    def test_find_a_and_b_given_sum_and_xor_returns_negative_one(self):
        """
        tests if the two values of a and b doed not exist
        """
        minimize_a_obj = SimumlteniousEQ()
        self.assertEqual(minimize_a_obj.find_a_and_b_given_sum_and_xor_values(3, 4), -1," returns -1")

    def test_get_sum_and_xor_from_user(self):
        """
        tests if the two values of a and b does not exist
        """
        minimize_a_obj = SimumlteniousEQ()
        result = minimize_a_obj.get_sum_and_xor_from_user("5 6")
        self.assertEqual(result, ['5', '6']," returns a list")

if __name__ == '__main__':
    unittest.main()