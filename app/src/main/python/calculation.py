import numpy as np
from scipy import optimize

def process_values(a, b, c):
    """
    Accepts individual numbers from Kotlin,
    uses NumPy and SciPy.
    """
    arr = np.array([a, b, c])
    sum_squares = np.sum(arr ** 2)

    # Example: find x that solves x^2 - 4 = 0
    root_result = optimize.root(lambda x: x**2 - 4, x0=1.0)

    return sum_squares, root_result.x[0]