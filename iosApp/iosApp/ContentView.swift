import SwiftUI
import shared
struct ContentView: View {
    let example = Example()
    
    var body: some View {
        VStack {
            Button(action: {
                self.example.callNetwork()
            }) {
                Text("Network Call")
            }
            Button(action: {
                self.example.callBackground()
            }) {
                Text("Background Call")
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
