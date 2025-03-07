//
//  ListView.swift
//  IOSSample
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//


//
//  ListView.swift
//  TesteKmp
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//


import SwiftUI
import VentuKitNetworking

struct ListView: View {
    
    @Environment(ViewModel.self) var viewModel

    
    var body: some View {
        
        VStack {
            
            ScrollView {
                Text(viewModel.greeting)
            }
            .frame(height: 300)
            
            List(viewModel.values, id: \.self) {
                Text($0)
            }
        }
        
        
    }
}
