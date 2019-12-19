# cordova-plugin-devoptionschecker

This is a cordova plugin that verifies if developer settings is enabled.

## Supported Platforms

-   Android API all versions

## Installation

cordova plugin add cordova-plugin-devoptionschecker

## Usage in javascript

```js
document.addEventListener('deviceready', onDeviceReady, false);

function onDeviceReady() {
	cordova.plugins.devoptionschecker.check(successCallback, errorCallback);
}

function successCallback(result) {
	// json object which returns devOptionsEnabled: true - enabled, false - disabled
	console.log(result);
}

function errorCallback(error) {
	console.log(error);
}
```
