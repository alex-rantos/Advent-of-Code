# Advent of Code 2020 Puzzle Solutions in Typescript

## Compilation

`tsc ./src/Day*.ts | node ./src/Day*.js` Both files are provided in this repo.

### Day 1

#### Part 1.1

Find two numbers in an array that sums to a target number. We tackle it by saving into a set the difference between the target number (minuend) with each number we have already "seen" (subtrahend). In that way if we find a number that's already in the set it means we have already at least one pair of numbers that sums to the target number.

#### Part 1.2

Find three numbers in an array that sums to a target number. We iterate the array and for each element we create a new target number by substracting that specific element from the original target element and we use our previous algorithm of part 1 to find two number that sums to the new target number.

### Day 2

Extract with regex the information from the input. Validate input according to spec.
