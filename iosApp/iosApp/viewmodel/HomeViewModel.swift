//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Deepak KK on 17/10/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI
class HomeViewModel: ObservableObject {
    @Published var viewModelState = ViewModelState.Loading
    @Published var simpleDataState = ViewModelState.Loading
    private let newsFeedUsecase : NewsFeedUseCase = koin.get()
    
    func loadingNewsFeed() {
        //var data =  Result[Articles]
        viewModelState = ViewModelState.Loading
        newsFeedUsecase.invoke{res, error in
            // if let data = res as AppR
            if let data = res as? AppRequestResult<AnyObject> {
                if let articleData = data.result as? [Articles] {
                    self.viewModelState = ViewModelState.FeedData(articleData)
                    self.simpleDataState = ViewModelState.SimlpeData(self.getDummyData(count: 1000))
                    debugPrint("Article Data:\(articleData.count)")
                }else {
                    self.viewModelState = ViewModelState.Error(msg: "Something went wrong")
                }
            }
        }
    }
    
    func getDummyData(count:Int)->[String] {
        var sampleList : [String] = []
        for index in 0...count-1 {
            
             if index%2==0 {
                 sampleList.append("\(index) is Even number")
            }else {
                sampleList.append("\(index) is Odd number")
            }
        }
        return sampleList
    }
}
