"use strict";
exports.__esModule = true;
var fs_1 = require("fs");
function find2Sum(target, data) {
    var mySet = new Set();
    for (var _i = 0, data_1 = data; _i < data_1.length; _i++) {
        var num = data_1[_i];
        var diff = target - num;
        if (mySet.has(num)) {
            return [num, diff];
        }
        else {
            mySet.add(diff);
        }
    }
    return [null, null];
}
function find3Sum(target, data) {
    var ret = [];
    data.forEach(function (elem, index) {
        var newTarget = target - elem;
        var _a = find2Sum(newTarget, data.slice(index + 1)), n1 = _a[0], n2 = _a[1];
        if (n1 && n2) {
            ret = [n1, n2, elem];
            console.log(n1, n2, elem);
            return false;
        }
    });
    return ret;
}
function main(target) {
    var file = fs_1.readFileSync("./src/input1.txt", "utf-8");
    var data = file.split("\r\n").map(function (x) { return Number(x); });
    var _a = find2Sum(target, data), n1 = _a[0], n2 = _a[1];
    console.log("Product of 2sum: " + n1 * n2);
    var _b = find3Sum(target, data), v1 = _b[0], v2 = _b[1], v3 = _b[2];
    console.log("Product of 3sum: " + v1 * v2 * v3);
}
main(2020);
