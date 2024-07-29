import { CopyAndroid } from 'skirank-copy-android';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    CopyAndroid.echo({ value: inputValue })
}
