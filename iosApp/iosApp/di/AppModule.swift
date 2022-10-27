//
//  AppModule.swift
//  iosApp
//
//  Created by Deepak KK on 14/10/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

func startKoin(){
    _koin = KoinModuleKt.doInitKoin().koin
}
private var _koin: Koin_coreKoin?

var koin: Koin_coreKoin {
    return _koin!
}

extension Koin_coreKoin {
    func get() -> NewsFeedUseCase {
        return koin.getDependency(objCClass: NewsFeedUseCase.self) as! NewsFeedUseCase
    }
}
