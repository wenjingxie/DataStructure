I estimated that I would spend 12 hours on this program. Actually I spent more than 16 hours. And 2 - 3 hours are used to read the assignment requirements. 


Analysis:
Based on the experiment results shown below:
1. Standard Tree Format Header always compressed more, especially when the file is small. And when the file is large, the advantage of Standard Tree Format Header is not so obvious.

2. When the file is really small, it is not cost effective to use Standard Count Format Header, and Standard Tree Format Header is much better.

3. The txt and HTML files could lead more compression than the tif graph files.

4. It is not a good idea to compress the compressed files again. Usually, it does not save much.



Experiment result:
=====Small test=====
~~~use Standard Count Format Header~~~~
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/smallTest/1.txt.hf
1.txt from	 26 to	 1044 in	 0.009
--------
total bytes read: 26
total compressed bytes 1044
total percent compression -3915.385
compression time: 0.009

~~~use Standard Tree Format Header~~~~
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/smallTest/1.txt.hf
1.txt from	 26 to	 41 in	 0.008
--------
total bytes read: 26
total compressed bytes 41
total percent compression -57.692
compression time: 0.008

=====large test=====
~~~use Standard Count Format Header~~~~
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/largeTest/ciaFactBook2008.txt.hf
ciaFactBook2008.txt from	 9637228 to	 6028799 in	 8.059
--------
total bytes read: 9637228
total compressed bytes 6028799
total percent compression 37.443
compression time: 8.059

~~~use Standard Tree Format Header~~~~
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/largeTest/ciaFactBook2008.txt.hf
ciaFactBook2008.txt from	 9637228 to	 6027913 in	 8.158
--------
total bytes read: 9637228
total compressed bytes 6027913
total percent compression 37.452
compression time: 8.158

=====When I run HuffMark on the calgary directory I get these results:====
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/bib.hf
bib from	 111261 to	 73795 in	 0.132
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/book1.hf
book1 from	 768771 to	 439409 in	 0.722
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/book2.hf
book2 from	 610856 to	 369335 in	 0.507
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/geo.hf
geo from	 102400 to	 73592 in	 0.106
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/news.hf
news from	 377109 to	 247428 in	 0.349
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/obj1.hf
obj1 from	 21504 to	 17085 in	 0.025
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/obj2.hf
obj2 from	 246814 to	 195131 in	 0.261
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/paper1.hf
paper1 from	 53161 to	 34371 in	 0.046
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/paper2.hf
paper2 from	 82199 to	 48649 in	 0.068
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/paper3.hf
paper3 from	 46526 to	 28309 in	 0.039
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/paper4.hf
paper4 from	 13286 to	 8894 in	 0.013
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/paper5.hf
paper5 from	 11954 to	 8465 in	 0.013
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/paper6.hf
paper6 from	 38105 to	 25057 in	 0.045
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/pic.hf
pic from	 513216 to	 107586 in	 0.185
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/progc.hf
progc from	 39611 to	 26948 in	 0.039
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/progl.hf
progl from	 71646 to	 44017 in	 0.057
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/progp.hf
progp from	 49379 to	 31248 in	 0.042
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/calgary/trans.hf
trans from	 93695 to	 66252 in	 0.092
--------
total bytes read: 3251493
total compressed bytes 1845571
total percent compression 43.239
compression time: 2.741

=====Then I tried to compress the compressed files again. The results are:=====
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/.DS_Store.hf
.DS_Store from	 6148 to	 1851 in	 0.020
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/bib.hf.hf
bib.hf from	 73795 to	 73700 in	 0.134
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/book1.hf.hf
book1.hf from	 439409 to	 435029 in	 0.616
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/book2.hf.hf
book2.hf from	 369335 to	 368074 in	 0.496
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/geo.hf.hf
geo.hf from	 73592 to	 74172 in	 0.116
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/news.hf.hf
news.hf from	 247428 to	 247029 in	 0.332
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/obj1.hf.hf
obj1.hf from	 17085 to	 17690 in	 0.026
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/obj2.hf.hf
obj2.hf from	 195131 to	 194792 in	 0.280
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/paper1.hf.hf
paper1.hf from	 34371 to	 34987 in	 0.050
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/paper2.hf.hf
paper2.hf from	 48649 to	 49040 in	 0.074
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/paper3.hf.hf
paper3.hf from	 28309 to	 28887 in	 0.038
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/paper4.hf.hf
paper4.hf from	 8894 to	 9431 in	 0.014
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/paper5.hf.hf
paper5.hf from	 8465 to	 9019 in	 0.018
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/paper6.hf.hf
paper6.hf from	 25057 to	 25698 in	 0.035
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/pic.hf.hf
pic.hf from	 107586 to	 72691 in	 0.105
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/progc.hf.hf
progc.hf from	 26948 to	 27469 in	 0.039
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/progl.hf.hf
progl.hf from	 44017 to	 44099 in	 0.062
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/progp.hf.hf
progp.hf from	 31248 to	 31540 in	 0.043
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed calgary/trans.hf.hf
trans.hf from	 66252 to	 66452 in	 0.092
--------
total bytes read: 1851719
total compressed bytes 1811650
total percent compression 2.164
compression time: 2.590


=====When I run HuffMark on the BooksAndHTML directory I get these results:====
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/BooksAndHTML/A7_Recursion.html.hf
A7_Recursion.html from	 41163 to	 26189 in	 0.067
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/BooksAndHTML/CiaFactBook2000.txt.hf
CiaFactBook2000.txt from	 3497369 to	 2260664 in	 3.002
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/BooksAndHTML/jnglb10.txt.hf
jnglb10.txt from	 292059 to	 168618 in	 0.262
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/BooksAndHTML/kjv10.txt.hf
kjv10.txt from	 4345020 to	 2489768 in	 3.389
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/BooksAndHTML/melville.txt.hf
melville.txt from	 82140 to	 47364 in	 0.067
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/BooksAndHTML/quotes.htm.hf
quotes.htm from	 61563 to	 38423 in	 0.052
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/BooksAndHTML/rawMovieGross.txt.hf
rawMovieGross.txt from	 117272 to	 53833 in	 0.071
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/BooksAndHTML/revDictionary.txt.hf
revDictionary.txt from	 1130523 to	 611618 in	 0.809
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/BooksAndHTML/syllabus.htm.hf
syllabus.htm from	 33273 to	 21342 in	 0.030
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/BooksAndHTML/ThroughTheLookingGlass.txt.hf
ThroughTheLookingGlass.txt from	 188199 to	 110293 in	 0.160
--------
total bytes read: 9788581
total compressed bytes 5828112
total percent compression 40.460
compression time: 7.909



=====Then I tried to compress the compressed files again. The results are:=====

compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed BooksAndHTML/A7_Recursion.html.hf.hf
A7_Recursion.html.hf from	 26189 to	 26340 in	 0.069
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed BooksAndHTML/CiaFactBook2000.txt.hf.hf
CiaFactBook2000.txt.hf from	 2260664 to	 2240008 in	 3.016
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed BooksAndHTML/jnglb10.txt.hf.hf
jnglb10.txt.hf from	 168618 to	 167167 in	 0.268
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed BooksAndHTML/kjv10.txt.hf.hf
kjv10.txt.hf from	 2489768 to	 2452980 in	 3.288
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed BooksAndHTML/melville.txt.hf.hf
melville.txt.hf from	 47364 to	 47551 in	 0.082
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed BooksAndHTML/quotes.htm.hf.hf
quotes.htm.hf from	 38423 to	 39036 in	 0.052
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed BooksAndHTML/rawMovieGross.txt.hf.hf
rawMovieGross.txt.hf from	 53833 to	 51821 in	 0.069
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed BooksAndHTML/revDictionary.txt.hf.hf
revDictionary.txt.hf from	 611618 to	 590850 in	 0.839
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed BooksAndHTML/syllabus.htm.hf.hf
syllabus.htm.hf from	 21342 to	 21841 in	 0.033
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed BooksAndHTML/ThroughTheLookingGlass.txt.hf.hf
ThroughTheLookingGlass.txt.hf from	 110293 to	 109626 in	 0.153
--------
total bytes read: 5828112
total compressed bytes 5747220
total percent compression 1.388
compression time: 7.869






=====When I run HuffMark on the waterloo directory I get these results:====
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/waterloo/clegg.tif.hf
clegg.tif from	 2149096 to	 2034595 in	 2.711
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/waterloo/frymire.tif.hf
frymire.tif from	 3706306 to	 2188593 in	 2.879
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/waterloo/lena.tif.hf
lena.tif from	 786568 to	 766146 in	 1.049
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/waterloo/monarch.tif.hf
monarch.tif from	 1179784 to	 1109973 in	 1.464
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/waterloo/peppers.tif.hf
peppers.tif from	 786568 to	 756968 in	 1.006
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/waterloo/sail.tif.hf
sail.tif from	 1179784 to	 1085501 in	 1.418
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/waterloo/serrano.tif.hf
serrano.tif from	 1498414 to	 1127645 in	 1.477
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/waterloo/tulips.tif.hf
tulips.tif from	 1179784 to	 1135861 in	 1.489
--------
total bytes read: 12466304
total compressed bytes 10205282
total percent compression 18.137
compression time: 13.493


=====Then I tried to compress the compressed files again. The results are:=====

compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed waterloo/clegg.tif.hf.hf
clegg.tif.hf from	 2034595 to	 2028486 in	 2.690
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed waterloo/frymire.tif.hf.hf
frymire.tif.hf from	 2188593 to	 2053957 in	 2.712
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed waterloo/lena.tif.hf.hf
lena.tif.hf from	 766146 to	 767426 in	 1.042
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed waterloo/monarch.tif.hf.hf
monarch.tif.hf from	 1109973 to	 1111386 in	 1.455
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed waterloo/peppers.tif.hf.hf
peppers.tif.hf from	 756968 to	 758099 in	 0.987
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed waterloo/sail.tif.hf.hf
sail.tif.hf from	 1085501 to	 1086679 in	 1.457
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed waterloo/serrano.tif.hf.hf
serrano.tif.hf from	 1127645 to	 1120034 in	 1.503
compressing to: /Users/wenjing/Documents/workspace/HuffmanCoding/compressed waterloo/tulips.tif.hf.hf
tulips.tif.hf from	 1135861 to	 1137290 in	 1.486
--------
total bytes read: 10205282
total compressed bytes 10063357
total percent compression 1.391
compression time: 13.332

