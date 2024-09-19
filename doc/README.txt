TestPerformance.java

----------
TODO #1
----------

int SIZE = 10, REPS = 1000000: 
total runtime: 82ms
ArrayListAccess runtime: 6ms
LinkedListAddRemove runtime: 16ms
LinkedListAccess runtime: 8ms
ArrayListAddRemove runtime: 40ms

int SIZE = 100, REPS = 1000000: 
total runtime: 90ms
ArrayListAccess runtime: 6ms
LinkedListAddRemove runtime: 16ms
LinkedListAccess runtime: 15ms
ArrayListAddRemove runtime: 50ms

int SIZE = 1000, REPS = 1000000: 
total runtime: 372ms
ArrayListAccess runtime: 7ms
LinkedListAddRemove runtime: 16ms
LinkedListAccess runtime: 200ms
ArrayListAddRemove runtime: 144ms

int SIZE = 10000, REPS = 1000000: 
total runtime: 3s 732ms
ArrayListAccess runtime: 9ms
LinkedListAddRemove runtime: 18ms
LinkedListAccess runtime: 2s 427ms
ArrayListAddRemove runtime: 1s 272ms

int SIZE = 100000, REPS = 1000000: 
total runtime: 47s 890ms
ArrayListAccess runtime: 17ms
LinkedListAddRemove runtime: 25ms
LinkedListAccess runtime: 32s 345msms
ArrayListAddRemove runtime: 15s 498ms


----------
TODO #2
----------

int SIZE = 100000, REPS = 10: 
total runtime: 22ms
ArrayListAccess runtime: 8ms
LinkedListAddRemove runtime: 4ms
LinkedListAccess runtime: 2ms
ArrayListAddRemove runtime: 3ms

int SIZE = 100000, REPS = 100: 
total runtime: 27ms
ArrayListAccess runtime: 9ms
LinkedListAddRemove runtime: 5ms
LinkedListAccess runtime: 2ms
ArrayListAddRemove runtime: 11ms

int SIZE = 100000, REPS = 1000: 
total runtime: 53ms
ArrayListAccess runtime: 11ms
LinkedListAddRemove runtime: 6ms
LinkedListAccess runtime: 3ms
ArrayListAddRemove runtime: 27ms

int SIZE = 100000, REPS = 10000: 
total runtime: 24ms
ArrayListAccess runtime: 11ms
LinkedListAddRemove runtime: 7ms
LinkedListAccess runtime: 66ms
ArrayListAddRemove runtime: 152ms

int SIZE = 100000, REPS = 100000: 
total runtime: 3s 992ms
ArrayListAccess runtime: 15ms
LinkedListAddRemove runtime: 18ms
LinkedListAccess runtime: 2s 575ms
ArrayListAddRemove runtime: 1s 379ms

int SIZE = 100000, REPS = 1000000: 
total runtime: 44s 104ms
ArrayListAccess runtime: 15ms
LinkedListAddRemove runtime: 24ms
LinkedListAccess runtime: 31s 548ms
ArrayListAddRemove runtime: 12s 511ms

----------
Conclusion
----------

It looks like ArrayListAccess was running
significant shorter than LinkedListAccess by
an order of 2,103%. However, ArrayListAddRemove
was running significantly longer than
LinkedListAddRemove by an order of 521%.

Behaviorally, the reason for this is because
for ArrayListAccess, the elements are stored to indices
which makes it very efficient to find them. In a 
linked list, the elements are represented by a node
that contains a reference to the element and a
reference to the next node in the list, which makes it
inefficient for simply accessing data.

However when manipulating data, such as with 
ArrayListAddRemove, we're required to create a 
new array that either inserts or removes the new 
element. With LinkedListAddRemove, we can just
iterate through until we find the intended value 
and then just reassign the node pointer.