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
            Image(uiImage: article.urlToImage?.loadUrlImage() ?? UIImage())
                .resizable()
                .frame(width: 48, height: 48)
                .fixedSize()
                .padding(4)
            VStack {
                Text(article.title ?? "").font(.title3)
                Text(article.content ?? "").font(.body).lineLimit(2)
            }
            
        }
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView(article: Articles.init(source: nil, author: "Deepak KK", title: "Test Title", description: "", urlToImage: "", content: ""))
    }
}
