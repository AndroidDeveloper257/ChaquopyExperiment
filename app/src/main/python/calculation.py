import numpy as np
from scipy import optimize

def process_values(a, b, c):
    arr = np.array([a, b, c])
    sum_squares = np.sum(arr ** 2)
    root_result = optimize.root(lambda x: x**2 - 4, x0=1.0)
    return sum_squares, root_result.x[0]