import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
    let sum  = MathEngine.init().sum(a: 20, b: 20)
	var body: some View {
        VStack(alignment: .trailing, spacing: 10) {
            Text("I am in iOs:\(UIDevice.current.systemVersion)")
            Text("I am from KMP")
                 HStack {
                     Text("I am Deepak KK").font(.subheadline)
                     Spacer()
                     Text("Test").font(.subheadline)
                 }.padding()
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
