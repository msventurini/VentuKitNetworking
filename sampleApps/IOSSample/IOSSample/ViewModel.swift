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
    var values: [String] = []
    
    var greeting: String = "aaaaa"
    
    func startObserving() async {
        
        let emittedValues = FlowValuesEmitter().oneToTenFlow()
        
        for await number in emittedValues {
            self.values.append(number)
        }
    }
    
    @MainActor
    func testSuspendedFunc() async {
        
        let client = ApiNetworkClient()
        
        do {
            try await Task.sleep(nanoseconds: 1_000_000_000)
            let newData = try await client.greeting()
            greeting = newData
            print("foi")
            
        } catch {
            print(error.localizedDescription)
        }
        
        
    }
    
}
