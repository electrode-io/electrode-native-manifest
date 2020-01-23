/**
 * Copyright 2017 WalmartLabs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#import "ElectrodeCodePushConfig.h"
#import <CodePush/CodePush.h>
#if __has_include(<React/RCTBridgeDelegate.h>)
#import <React/RCTBridgeDelegate.h>
#elif __has_include("RCTBridgeDelegate.h")
#import "RCTBridgeDelegate.h"
#else
#import "React/RCTBridgeDelegate.h"   // Required when used as a Pod in a Swift project
#endif
#import "ElectrodeBridgeDelegate.h"

@interface ElectrodeCodePushConfig()
@property(nonatomic, copy) NSString *deploymentKey;
@property(nonatomic, copy, nullable) NSString *serverURL;
@property(nonatomic, weak, nullable) ElectrodeContainerConfig *containerConfig;
@end

@implementation ElectrodeCodePushConfig

- (instancetype) initWithDeploymentKey:(NSString *)deploymentKey
                             serverURL: (NSString * _Nullable)serverURL
                       containerConfig: (ElectrodeContainerConfig *)containerConfig
{
    if (self = [super init]) {
        _deploymentKey = deploymentKey;
        _serverURL = serverURL;
        _containerConfig = containerConfig;
    }
    return self;
}

- (void)setupConfigWithDelegate: (id<RCTBridgeDelegate>) delegate {
    [CodePush initialize];
    [CodePush setDeploymentKey:self.deploymentKey];
    if (self.serverURL) {
      [CodePushConfig current].serverURL = self.serverURL;
    }
    if (!self.containerConfig.debugEnabled) {
        if ([delegate isKindOfClass:[ElectrodeBridgeDelegate class]]) {
            ElectrodeBridgeDelegate *bridgeDelegate = (ElectrodeBridgeDelegate *)delegate;
            [bridgeDelegate setJsBundleURL:[self codePushBundleURL]];
        }
    }
}

- (NSURL *) codePushBundleURL {
    NSURL *url = [CodePush bundleURLForResource:@"MiniApp"
                                  withExtension:@"jsbundle"
                                   subdirectory:nil
                                         bundle:[NSBundle bundleForClass:[self class]]];
    return url;
}

@end
