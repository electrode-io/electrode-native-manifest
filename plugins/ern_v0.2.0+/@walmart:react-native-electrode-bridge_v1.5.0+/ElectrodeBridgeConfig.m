//
//  ElectrodeBridgePluginConfig.m
//  ElectrodeContainer
//
//  Created by Claire Weijie Li on 7/6/17.
//  Copyright © 2017 Walmart. All rights reserved.
//

#import "ElectrodeBridgeConfig.h"

#if __has_include(<React/RCTBridgeDelegate.h>)
#import <React/RCTBridgeDelegate.h>
#elif __has_include("RCTBridgeDelegate.h")
#import "RCTBridgeDelegate.h"
#else
#import "React/RCTBridgeDelegate.h"   // Required when used as a Pod in a Swift project
#endif

#import "ElectrodeBridgeDelegate.h"


@implementation ElectrodeBridgeConfig

- (instancetype)initWithDebugEnabled: (BOOL)enabled {
    if (self = [super init]) {
        _debugEnabled = enabled;
    }
    
    return self;
}

- (void) setupConfigWithDelegate:(id<RCTBridgeDelegate>)delegate {
    NSURL *url;
    if (self.debugEnabled) {
        url = [NSURL URLWithString:@"http://localhost:8081/index.ios.bundle?platform=ios&dev=true"];
        NSLog(@"using local port to debug");
    } else {
        NSArray *returnFiles = nil;
        NSURL *bundle = [[NSBundle bundleForClass:self.class] bundleURL];
        NSError *error = nil;
        
        NSArray *files =
        [[NSFileManager defaultManager] contentsOfDirectoryAtURL:bundle
                                      includingPropertiesForKeys:nil
                                                         options:NSDirectoryEnumerationSkipsHiddenFiles
                                                           error:&error];
        if (!error)
        {
            NSPredicate *jsBundlePredicate = [NSPredicate predicateWithFormat:@"pathExtension='jsbundle'"];
            returnFiles = [files filteredArrayUsingPredicate:jsBundlePredicate];
        }
        
        url = returnFiles[0];
    }
    
    if ([delegate respondsToSelector:@selector(setJsBundleURL:)]) {
        ElectrodeBridgeDelegate *bridgeDelegate = (ElectrodeBridgeDelegate *)delegate;
        [bridgeDelegate setJsBundleURL:url];
    }
}

@end
