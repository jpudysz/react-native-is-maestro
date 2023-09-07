#import "IsMaestro.h"

#if RCT_NEW_ARCH_ENABLED
#import "RNIsMaestroSpec.h"
#endif

@implementation IsMaestro
RCT_EXPORT_MODULE()

// this function is cleaner and doesn't block thread
// for now awaiting for meastro team to fix connection issue
- (BOOL)isPortReachable:(NSString *)ipAddress port:(NSInteger)port {
    CFSocketRef socketRef = CFSocketCreate(kCFAllocatorDefault,
                                           PF_INET,
                                           SOCK_STREAM,
                                           IPPROTO_TCP,
                                           kCFSocketConnectCallBack,
                                           nil,
                                           NULL);

    struct sockaddr_in addr_in;

    memset(&addr_in, 0, sizeof(addr_in));
    addr_in.sin_family = AF_INET;
    addr_in.sin_port = htons(port);

    NSString *urlPath = [NSString stringWithFormat:@"%@:%zd", ipAddress, port];

    addr_in.sin_addr.s_addr = inet_addr([urlPath UTF8String]);

    CFDataRef dataRef = CFDataCreate(kCFAllocatorDefault, (UInt8 *)&addr_in, sizeof(addr_in));
    CFSocketError sockError = CFSocketConnectToAddress(socketRef, dataRef, kCFSocketConnectCallBack);

    BOOL isReachable = sockError == kCFSocketSuccess;

    CFRelease(dataRef);
    CFSocketInvalidate(socketRef);
    CFRelease(socketRef);

    return isReachable;
}

- (BOOL)isUrlReachable:(NSString *)ipAddress port:(NSInteger)port {
    __block BOOL isRunning = NO;
    dispatch_semaphore_t semaphore = dispatch_semaphore_create(0);

    NSString *urlPath = [NSString stringWithFormat:@"%@:%zd", ipAddress, port];
    NSURL *url = [NSURL URLWithString:urlPath];

    if (!url) {
        return NO;
    }

    [[[NSURLSession sharedSession] dataTaskWithURL:url completionHandler:^(NSData * _Nullable data, NSURLResponse * _Nullable response, NSError * _Nullable error) {
        if (error) {
            isRunning = NO;
        } else {
            NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
            isRunning = httpResponse.statusCode == 404;
        }
        dispatch_semaphore_signal(semaphore);
    }] resume];
    dispatch_semaphore_wait(semaphore, DISPATCH_TIME_FOREVER);

    return isRunning;
}

RCT_EXPORT_METHOD(isMaestro:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)
{
    BOOL isReachable = NO;
    NSArray *maestroPorts = @[@22087, @9999];

    for (NSNumber *port in maestroPorts) {
        isReachable = [self isUrlReachable:@"http://localhost" port:[port intValue]];

        if (isReachable) {
            break;
        }
    }

    resolve(@(isReachable));
}

// Don't compile this code when we build for the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeIsMaestroSpecJSI>(params);
}
#endif

@end
