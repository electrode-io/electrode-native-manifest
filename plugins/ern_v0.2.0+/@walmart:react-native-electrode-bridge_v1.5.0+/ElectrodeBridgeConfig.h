//
//  ElectrodeBridgePluginConfig.h
//  ElectrodeContainer
//
//  Created by Claire Weijie Li on 7/6/17.
//  Copyright © 2017 Walmart. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "ElectrodeReactNative.h"

@interface ElectrodeBridgeConfig: NSObject<ElectrodePluginConfig>
@property (nonatomic, assign) BOOL debugEnabled;
@property (nonatomic, strong) NSURL *jsBundleURL;
- (instancetype)initWithDebugEnabled: (BOOL)enabled;
@end
