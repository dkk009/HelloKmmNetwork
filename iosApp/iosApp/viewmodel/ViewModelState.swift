//
//  ViewModelState.swift
//  iosApp
//
//  Created by Deepak KK on 17/10/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared
enum ViewModelState{
    case Loading
    case FeedData([Articles])
    case Error(msg:String)
}
