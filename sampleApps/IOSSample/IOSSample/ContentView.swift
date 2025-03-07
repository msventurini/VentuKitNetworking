//
//  ContentView.swift
//  TesteKmp
//
//  Created by Matheus Silveira Venturini on 02/03/25.
//

import SwiftUI
import VentuKitNetworking

struct ContentView: View {
    @Environment(ViewModel.self) var viewModel

    var body: some View {
        VStack {
            Button("Start Receiving") {
                Task {
                    await viewModel.testSuspendedFunc()
                    await viewModel.startObserving()
                }
            }
//            Text(viewModel.greeting)
            ListView()
        }
    }
}


#Preview(traits: .modifier(CachedPreviewData())) {
    ContentView()
}
