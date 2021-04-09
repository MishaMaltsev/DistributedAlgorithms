# Activity 1 README

## Task 1 Getting Started

### 1. Explain the main structure of this code and the advantages and disadvantages of the setup of the distributed algorithm.

>The main structure of this code is that there are sorters, which is a node. the sorters get arrays sent to them and can manipulate the data to sort it. There are branches that are also nodes which get a big array and they split it into smaller arrays that will get sent to the sorters. The first half of the big array goes to the first sorter and the second half goes to the second sorter. The branch then gets the smallest element from both sorters, and will compare them to see which one needs to be sent first. It then removes the element it found to be the smallest, removes it, and repeats, returning the elements in the array sorted least to greatest. The MergeSort starts the whole process by sending the array and calling methods of the branch. All the information is sent and recieved through NetworkUtils, which is sending and recieving JSONObjects.


### 2. Run the code with different arrays to sort (different sizes, numbers etc.) and include code to measure the time (you can just enter start and end times)

> In your Readme describe your experiments and your analyzes of them. E.g. why is the result as it is? Does the distribution help? Why, why not? See this as setting up your own experiment and give me a good description and evaluation.

> Time: 0.1003547 seconds { 100, 200, 6400, 212, 33, 4123, 102132312,623234,2334,212313,6553, 2653,256 ,6566, 45,787, 56345, 54756,3453452,345,657,1,2,3,4,7,567,7,7,7} 

> Time: 0.0632237 seconds { 5, 1, 6, 2, 3, 4, 10,634,34,23,653, 23,2 ,6}

> Time: 0.2007109 seconds { 100, 200, 6400, 212, 33, 4123, 102132312,623234,2334,212313,6553, 2653,256 ,6566, 45,787, 56345, 54756,3453452,345,657,1,2,3,4,7,567,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,1,23,4,3,4,5,6,4,5,74,8,2,3,4,2745,9,86,7,7,2,3,4,2,4,67,4,5,6,323,4,567897,6,54345,6,765,46,787,64,753,25679529, 1,1,1,1,1,1,1,1,1,1,0,0,0,-1}

> It looks like the results are fairly predictable. With the different arrays, the results were all sorted correctly, including the correct results with a negative. It is not really clear if the distribution is helping, as more elements in the array does increase the time, but it does not necessarily scale as expected with the number of elements in the array. Between the first and second test, there was an increase of 0.04 seconds with a bit over double the number of elements, but there was substaintally more elements in the third test (more than double the second) but the time was only doubled.

### 3. Experiment with the "tree" setup, what happens with more or less nodes when sorting the same array and different arrays? When does the distribution make things better? Does it ever make things faster? As in the previous step experiment and describe your experiment and your results in detail.

> When there are more nodes sorting the larger arrays, less time is taken to sort it all. the time for using two sorters for the long input was 0.2007109 seconds, while using 4 sorters and 2 branches was 0.1826871 seconds. Adding in another branch and 2 sorters reduce the time to 0.1631038 seconds. The more sorters for larger arrays, the faster it will complete the sorting.

### 4. Explain the traffic that you see on Wireshark. How much traffic is generated with this setup and do you see a way to reduce it?

> There is a substantial amount of communication through UDP. I think that this is a fairly low amount of traffic for this, and reducing it would mean changing the system significantly.

## Task 2 - Running it outside of localhost

### 1. Do you expect changes in runtimes? Why, why not?

>The runtimes should most likley be slower due to latency. Since it has to connect over WIFI instead of just over the local network, I would assume that it would be slower.

### 2. Do you see a difference how long it takes to sort the arrays? Explain the differences (or why there are not differences)

> After running it, I was surprised to see that it was actually faster, doing the longest task that took 0.2 seconds on localhost in 0.13 seconds. I also noticed though that a substantial amount of the data is missing. It is most likely faster because some data was lost in the process, and only a fraction of the results were returned.

## Task 3 - how to improve

> Speed is not bad, but it does not return the correct data. Using TCP instead of UDP could be a way to improve, sacraficing speed for some more reliability. If it must stay in UDP, then there would have to be a lot more work done in the program to ensure that is has all the data it needs, find missing data, and put it in the correct place.

### 1. Where is the most time lost and could you make this more efficient?

> Most of the time is lost in the localhost where the data is more reliably translated. It is also lost the most when having few branches and sorters. The more a sorter has to sort, the slower the program is on average. To make it more efficient, it would need to have additional sorters, and possibly a branch that could take on more sorters rather than just two.

### 2. Does it make sense to run the algorithm as a distributed algorithm? Why or why not?

> It does not make much sense to run this program as a distributed algorithm because the task that it is handling does not take long, and it makes it more complicated, opening up chances for errors. This would make more sense if it was dealing with massive amounts of numbers when speed was critical. Due to the opportunity for innaccuracy, it would not be the best option.




