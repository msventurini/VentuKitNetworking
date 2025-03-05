//
//  CachedPreviewData.swift
//  IOSSample
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//


//
//  PreviewEnvironmentCache.swift
//  TesteKmp
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//

import Foundation
import VentuKitNetworking
import SwiftUI

struct CachedPreviewData: PreviewModifier {

    static func makeSharedContext() async throws -> ViewModel {
        var viewModel = ViewModel()
        
        return viewModel
    }


    // And now it's reused
    func body(content: Content, context: ViewModel) -> some View {
        content
            .environment(context)
    }
    
}
