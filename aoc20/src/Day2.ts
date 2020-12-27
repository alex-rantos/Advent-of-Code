import { readFileSync } from "fs";

function isValid(data: [string], part: "part1" | "part2"): number {
  let count: number = 0;
  data.map((x) => {
    switch (part) {
      case "part1":
        count += analyzePart1(x);
        break;
      case "part2":
        count += analyzePart2(x);
        break;
      default:
        throw new Error("Wrong parameter: " + part);
    }
  });
  return count;
}

function analyzePart1(input: string): number {
  const [low, high, target, pass] = input.split(/[- ]/);
  const reg = new RegExp(target[0], "g");
  const occurences: number = (pass.match(reg) || []).length;
  if (occurences >= Number(low) && occurences <= Number(high)) {
    return 1;
  }
  return 0;
}

function analyzePart2(input: string): number {
  let [low, high, target, pass] = input.split(/[- ]/);

  target = target[0];

  let l = Number(low) - 1,
    h = Number(high) - 1;

  let cnt = 0;

  if (l - 1 < input.length && pass[l] === target) {
    cnt += 1;
  }

  if (h < input.length && pass[h] === target) {
    cnt += 1;
  }
  return cnt === 1 ? 1 : 0;
}

function main(target: number): void {
  const file = readFileSync("./src/input2.txt", "utf-8");
  const data: [string] = file.split("\r\n");
  console.log(isValid(data, "part1"));
  console.log(isValid(data, "part2"));
}

main(2020);
