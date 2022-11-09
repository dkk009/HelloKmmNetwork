import SwiftUI
import shared

struct ContentView: View {
	
    @ObservedObject
    private var homeViewModel = HomeViewModel()
    var body: some View {
        VStack() {
            NavigationView {
                uiState().navigationTitle("News Feed")
            }
        }.onAppear() {
            homeViewModel.loadingNewsFeed()
        }
    }
    
    private func uiState()->AnyView {
        switch homeViewModel.viewModelState {
        case ViewModelState.Loading:
            return AnyView(ZStack {
                ProgressView().progressViewStyle(CircularProgressViewStyle(tint: .green)).scaleEffect(2)
            }.multilineTextAlignment(.center))
            
        case ViewModelState.FeedData(let articles):
            return AnyView(
                
                List(articles, id: \.self.title) { article in
                    NavigationLink {
                        NewsDataView(article: article)
                    } label: {
                        HomeView(article: article)

                    }
                }.listStyle(PlainListStyle())
            )
        case ViewModelState.Error(let message):
            return AnyView (
                Text("Error loading in data:\(message)")
            )
        }
    }
}

    struct ContentView_Previews: PreviewProvider {
        static var previews: some View {
            Group {
                ContentView()
            }
        }
    }
