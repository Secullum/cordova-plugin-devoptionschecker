var exec = require("cordova/exec");

exports.check = function(success, error) {
  exec(success, error, "DevOptionsChecker", "check", []);
};
