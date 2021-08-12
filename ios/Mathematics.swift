import Expression

@objc(Mathematics)
class Mathematics: NSObject {
    
    @objc(calculate:withResolver:withRejecter:)
    func calculate(formulae: [String:[String:Any]], resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
        let output:NSMutableDictionary = [:];
        for (key, data) in formulae {
            let expression = Expression((data["formula"] as? String)!, constants: (data["values"] as? [String: Double])!);
            do {
                let result = try expression.evaluate();
                output.setValue(result, forKey: key);
            } catch {
                NSLog("Error in %@", key);
            }
        }
        resolve(output);
    }
}
