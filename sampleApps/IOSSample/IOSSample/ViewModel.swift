//
//  ViewModel.swift
//  IOSSample
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//


//
//  ViewModel.swift
//  TesteKmp
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//


import SwiftUI
import VentuKitNetworking

@Observable class ViewModel {
    
    let client: NetworkClient //= ApiNetworkClient()

    init(client: NetworkClient) {
        self.client = client
    }
    
    var values: [GameData] = []
    
    var greeting: String = "aaaaa"
    
    func startObserving() async {
        
//        let emittedValues = FlowValuesEmitter().oneToTenFlow()
        let emittedValues = client.listEmitter()
        
        for await game in emittedValues {
            self.values.append(game)
        }
    }
    
    @MainActor
    func testSuspendedFunc() async {
        
        
        do {
            let newData = try await client.greeting()
            greeting = newData
            print("foi")
            
        } catch {
            print(error.localizedDescription)
        }
        
        
    }
    
}
