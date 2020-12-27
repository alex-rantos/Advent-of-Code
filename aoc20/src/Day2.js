"use strict";
exports.__esModule = true;
var fs_1 = require("fs");
function analyze(input) {
    var _a = input.split(/[- ]/), low = _a[0], high = _a[1], target = _a[2], pass = _a[3];
    var reg = new RegExp(target[0], "g");
    var occurences = (pass.match(reg) || []).length;
    if (occurences >= Number(low) && occurences <= Number(high)) {
        return 1;
    }
    return 0;
}
function main(target) {
    var file = fs_1.readFileSync("./src/input2.txt", "utf-8");
    var data = file.split("\r\n");
    var count = 0;
    data.map(function (x) { return (count += analyze(x)); });
    console.log(count);
}
main(2020);
