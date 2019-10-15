# cordova-plugin-devoptionschecker

This is a cordova plugin to verify if developer settings is enable.

## Supported Platforms

- Android API all versions

## Installation

cordova plugin add cordova-plugin-devoptionschecker

## Usage in javascript

```js
document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
  cordova.plugins.devoptionschecker.check(successCallback, errorCallback);
}

function successCallback(result) {
  // json object wich returns devOptionsEnabled: true - enabled, false - disabled
  console.log(result);
}

function errorCallback(error) {
  console.log(error);
}
```