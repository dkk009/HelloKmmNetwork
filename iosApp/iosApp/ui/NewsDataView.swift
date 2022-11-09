//
//  NewsDataView.swift
//  iosApp
//
//  Created by Deepak KK on 21/10/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared
struct NewsDataView: View {
    let article: Articles
    var body: some View {
        ScrollView {
            VStack {
                Text(article.title ).font(.title)
                Spacer(minLength: 10)
                Text(article.content ?? "").font(.body)
                Spacer(minLength: 10)
                if let author = article.author {
                    Text("Author:\(author.description)").font(.body)
                }
                Image(uiImage: article.urlToImage?.loadUrlImage() ?? UIImage()).resizable().frame(width: 100, height:100).fixedSize().padding(8)
            }.padding(20)
        }
    }
}

extension String {
    func loadUrlImage() -> UIImage {
        do {
            guard let url = URL(string: self) else {return UIImage()}
            let data: Data = try Data(contentsOf: url)
            return UIImage(data: data) ?? UIImage()
        } catch {
            return UIImage()
        }
    }
}
struct NewsDataView_Previews: PreviewProvider {
    static var previews: some View {
        NewsDataView(article: Articles.init())
    }
}
