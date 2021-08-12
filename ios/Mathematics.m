#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(Mathematics, NSObject)

RCT_EXTERN_METHOD(calculate:(NSDictionary)formulae
                 withResolver:(RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)

@end
