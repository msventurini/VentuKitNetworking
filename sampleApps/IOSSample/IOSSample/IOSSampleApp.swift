//
//  IOSSampleApp.swift
//  IOSSample
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//

import SwiftUI
import VentuKitNetworking

@main
struct IOSSampleApp: App {
    
    @State var viewModel: ViewModel = ViewModel(client: ApiNetworkClient())
    
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environment(viewModel)
        }
    }
}
