#import "IsMaestro.h"

@implementation IsMaestro

RCT_EXPORT_MODULE()

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

RCT_EXPORT_BLOCKING_SYNCHRONOUS_METHOD(isMaestro)
{
    bool isReachable = [self isUrlReachable:@"http://localhost" port:22087];
    
    return @(isReachable);
}

@end
