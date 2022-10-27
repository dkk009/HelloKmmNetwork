import SwiftUI
import shared

struct ContentView: View {
	
    @ObservedObject
    private var homeViewModel = HomeViewModel()
    var body: some View {
        VStack() {
            NavigationView {
                uiState().navigationTitle("Hello KMM Network")
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
                
                List(0 ..< articles.count-1) { index in
                    NavigationLink {
                        NewsDataView(article: articles[index])
                    } label: {
                        HomeView(article: articles[index])
                        
                    }
                }
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
