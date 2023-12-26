from pylab import *
import matplotlib.pyplot as plt
import numpy as np

x = []; y = [];
x_ = []; y_ = [];
x__ = []; y__ = [];
# f = open("trieInsert.txt", "r")
f = open("trieMemo.txt", "r")
id = 0;
for t in f:
    if (id == 0):
        x.append(int(t))
    else:
        y.append(int(t));
    id ^= 1;
f.close();
# f = open("bstInsert.txt", "r")
f = open("bstMemo.txt", "r")
id = 0;
for t in f:
    print(int(t))
    if (id == 0):
        x_.append(int(t))
    else:
        y_.append(int(t));
    id ^= 1;
f.close();
# f = open("hashmapInsert.txt", "r")
f = open("hashmapMemo.txt", "r")
id = 0;
for t in f:
    if (id == 0):
        x__.append(int(t))
    else:
        y__.append(int(t));
    id ^= 1;
f.close();
xx = np.array(x)
yy = np.array(y)
xxx = np.array(x_)
yyy = np.array(y_)
xxxx = np.array(x__);
yyyy = np.array(y__);
# plt.plot(xx, yy,label = 'Trie Insert');
# plt.plot(xxx, yyy, label = 'BST Insert');
# plt.plot(xxxx, yyyy, label = 'Hash Map Insert');
plt.plot(xx, yy,label = 'Trie Memo');
plt.plot(xxx, yyy, label = 'BST Memo');
plt.plot(xxxx, yyyy, label = 'Hash Map Memo');
# plt.title('Vẽ biểu đồ so sánh thêm từ vào trong Trie, BST, HashMap')
# plt.title('Vẽ biểu đồ so sánh khớp từ trong Trie và BST, HashMap')
plt.title('Vẽ biểu đồ so sánh không gian lưu trũ trong Trie và BST, HashMap')
plt.xlabel('Số lượng từ')
plt.ylabel('Không gian lưu trữ chương trình (bytes)')
plt.legend(loc='best')
# plt.xlim(1,57000)
# plt.ylim(673962,116296113)
plt.show()