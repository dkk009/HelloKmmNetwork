//
//  HomeView.swift
//  iosApp
//
//  Created by Deepak KK on 23/10/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared
struct HomeView: View {
    let article: Articles
    var body: some View {
        HStack {
            AsyncImage(url: URL(string: article.urlToImage ?? ""),content:  {image in
                image.resizable().scaledToFill()
            } , placeholder: {
                Color.purple.opacity(0.1)
            }).frame(width: 60, height:60).cornerRadius(8).padding(8)

            VStack {
                Text(article.title ).font(.title3)
                Text(article.content ?? "").font(.body).lineLimit(2)
            }
            
        }
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView(article: Articles.init())
    }
}
