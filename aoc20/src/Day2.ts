import { readFileSync } from "fs";

function analyze(input: string): number {
  const [low, high, target, pass] = input.split(/[- ]/);
  const reg = new RegExp(target[0], "g");
  const occurences: number = (pass.match(reg) || []).length;
  if (occurences >= Number(low) && occurences <= Number(high)) {
    return 1;
  }
  return 0;
}

function main(target: number): void {
  const file = readFileSync("./src/input2.txt", "utf-8");
  const data = file.split("\r\n");
  let count: number = 0;
  data.map((x) => (count += analyze(x)));
  console.log(count);
}

main(2020);
