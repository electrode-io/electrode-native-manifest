//
//  ElectrodeBridgeConfig.m
//  ErnRunner
//
//  Created by Claire Weijie Li on 7/31/17.
//  Copyright © 2017 Claire Weijie Li. All rights reserved.
//

#import "ElectrodeBridgeConfig.h"
#if __has_include(<React/RCTBridgeDelegate.h>)
#import <React/RCTBridgeDelegate.h>
#elif __has_include("RCTBridgeDelegate.h")
#import "RCTBridgeDelegate.h"
#else
#import "React/RCTBridgeDelegate.h"   // Required when used as a Pod in a Swift project
#endif
@implementation ElectrodeBridgeConfig
- (void)setupConfigWithDelegate: (id<RCTBridgeDelegate>) delegate {

}
@end
