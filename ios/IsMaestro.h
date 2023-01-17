
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNIsMaestroSpec.h"

@interface IsMaestro : NSObject <NativeIsMaestroSpec>
#else
#import <React/RCTBridgeModule.h>

@interface IsMaestro : NSObject <RCTBridgeModule>
#endif

@end
