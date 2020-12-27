import { readFileSync } from "fs";

function find2Sum(target: number, data: number[]): [number, number] {
  let mySet: Set<number> = new Set();
  for (let num of data) {
    let diff = target - num;
    if (mySet.has(num)) {
      return [num, diff];
    } else {
      mySet.add(diff);
    }
  }
  return [null, null];
}

function find3Sum(target: number, data: number[]): number[] {
  let ret = [];

  data.forEach((elem, index) => {
    let newTarget = target - elem;
    const [n1, n2] = find2Sum(newTarget, data.slice(index + 1));
    if (n1 && n2) {
      ret = [n1, n2, elem];
      console.log(n1, n2, elem);
      return false;
    }
  });

  return ret;
}

function main(target: number): void {
  const file = readFileSync("./src/input1.txt", "utf-8");
  const data = file.split("\r\n").map((x) => Number(x));

  const [n1, n2] = find2Sum(target, data);
  console.log(`Product of 2sum: ${n1 * n2}`);

  const [v1, v2, v3] = find3Sum(target, data);
  console.log(`Product of 3sum: ${v1 * v2 * v3}`);
}

main(2020);
