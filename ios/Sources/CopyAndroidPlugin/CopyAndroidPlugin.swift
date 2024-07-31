import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(CopyAndroidPlugin)
public class CopyAndroidPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "CopyAndroidPlugin"
    public let jsName = "CopyAndroid"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "echo", returnType: CAPPluginReturnPromise)
    ]
    private let implementation = CopyAndroid()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }

    @objc func copy(_ call: CAPPluginCall) {
        call.unimplemented("Not implemented on iOS.");
    }
}
