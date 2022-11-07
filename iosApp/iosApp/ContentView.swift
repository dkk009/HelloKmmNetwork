import SwiftUI
import shared

struct ContentView: View {
	
    @ObservedObject
    private var homeViewModel = HomeViewModel()
    var body: some View {
        VStack() {
            NavigationView {
                //uiState().navigationTitle("Hello KMM Network")
//                List(homeViewModel.getDummyData(count: 10000), id: \.self) { item in
//                   Text(item)
//                }
                uiState().navigationTitle("Hello Swift UI")
            }
        }.onAppear() {
            homeViewModel.loadingNewsFeed()
           // homeViewModel.getDummyData(count: 100)
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
                    //Text(article.title ?? "")
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
        case ViewModelState.SimlpeData(let data):
            debugPrint("Simple Data")
            return AnyView(Text("Sample data:"))
        }
    }
    private func sampleNavUiState() -> AnyView {
        switch homeViewModel.simpleDataState {
        case ViewModelState.Loading:
            return AnyView(ProgressView().progressViewStyle(CircularProgressViewStyle(tint: .blue)))
        
        case ViewModelState.FeedData(let dataSet):
            return AnyView(Text("Hello Data"))
    
        case ViewModelState.Error(let message) :
            return AnyView(Text("Hello Data"))
        case ViewModelState.SimlpeData(let data):
            return AnyView(
                List(data, id: \.self) { item in
                   Text(item)
                }
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
