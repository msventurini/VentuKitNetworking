//
//  IOSSampleApp.swift
//  IOSSample
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//

import SwiftUI

@main
struct IOSSampleApp: App {
    
    @State var viewModel: ViewModel = ViewModel()

    
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environment(viewModel)
        }
    }
}
