"use strict";
exports.__esModule = true;
var fs_1 = require("fs");
function isValid(data, part) {
    var count = 0;
    data.map(function (x) {
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
function analyzePart1(input) {
    var _a = input.split(/[- ]/), low = _a[0], high = _a[1], target = _a[2], pass = _a[3];
    var reg = new RegExp(target[0], "g");
    var occurences = (pass.match(reg) || []).length;
    if (occurences >= Number(low) && occurences <= Number(high)) {
        return 1;
    }
    return 0;
}
function analyzePart2(input) {
    var _a = input.split(/[- ]/), low = _a[0], high = _a[1], target = _a[2], pass = _a[3];
    target = target[0];
    var l = Number(low) - 1, h = Number(high) - 1;
    var cnt = 0;
    if (l - 1 < input.length && pass[l] === target) {
        cnt += 1;
    }
    if (h < input.length && pass[h] === target) {
        cnt += 1;
    }
    return cnt === 1 ? 1 : 0;
}
function main(target) {
    var file = fs_1.readFileSync("./src/input2.txt", "utf-8");
    var data = file.split("\r\n");
    console.log(isValid(data, "part1"));
    console.log(isValid(data, "part2"));
}
main(2020);
