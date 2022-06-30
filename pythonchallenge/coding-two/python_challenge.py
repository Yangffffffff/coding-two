# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import numpy as np


a = np.zeros((3,3))


#%%


b = np.linspace(0, 10)

#%%

import matplotlib.pyplot as plt

#%%

plt.matshow(b)

#%%

b_matrix = b.reshape((5,10))

#%%

img = np.zeros((256,256))


plt.matshow(img, cmap='gray')


#%%



from PIL import Image

img_a = Image.fromarray(img)

#%%

#solution:
    
import matplotlib.pyplot as plt
import numpy as np


img_read = plt.imread('a.png')

print(img_read.shape)


#%%

img_r = img_read[:,:,0]


print(np.where(img_r==1))



#%%

import random

my_string = ''

# 97 - 122

for x in range(256):
    for y in range(256):
        if x == 24 and y == 45:
            my_string += 'o'
        else:
            ascii_num = random.randint(97,122)
            my_string += chr(ascii_num)
    my_string += '\n'


#%%

f = open("code.txt", "w")
f.write(my_string)
f.close()



# answer is 'o'


