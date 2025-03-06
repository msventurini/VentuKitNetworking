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
                    await viewModel.startObserving()
                }
            }
            ListView(numbers: viewModel.values)
        }
    }
}


#Preview(traits: .modifier(CachedPreviewData())) {
    ContentView()
}
