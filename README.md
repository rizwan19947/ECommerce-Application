Ecommerce Application: A Product listing app the basis of which relies on MVVM (Model, View, ViewModel) architecture. 

Language:   Kotlin
IDE:        Android Studio

Packages within the Application:    Adapters
                                    Models
                                    Network
                                    Repositories
                                    Viewmodels
                                    Views
                                    
                                    
                                    
                                    
API Used:     
        The dummy products API provided within the assessment https://fakestoreapi.com/ has been used]
        
        
        
        

Minimum API Required to run the project: 
                                        The minimuim API Level required to launch the project is 21
                                        
                                        
                                        
                                        

Application Structure: 
                    Given how the application follows MVVM, the project is divided into the aforementioned packages. 
                    The frontend of the application comprises of four separate fragments that are being navigated though
                        with the implementation of nav_graph. The four components are: 
                                                                                        1.Splash Screen 
                                                                                        2.Market Listing 
                                                                                        3.Cart
                                                                                        4.Product Description
                                                            
                    The application uses Retrofit for API calls through Hilt via dependency injection for the ViewModel calss
                    The API call returns JSON objects. 
                    
                    The nav_graph is attached to the main activity which initializes splash screen and moves the user towards the marketlisting fragment.
                    The marketlisting fragment displays the product data retrieved through the API in a Staggered Recycleview. The StaggeredRecycleView Adapter
                    also implements an interface to pass the product data across to the other fragments within the application. 
                    
                    Each fragment uses databinding to refer to their objects. 
                    
                    Glide is used to display the images via feeding the image URLs acquired thorugh the product data. 
                    
                    
What is incomplete: 
                    Cart Functionality:
                                    The cart fragment implementing a linear recycleview does not have an adapter, due to which the cart does not show any data.
                                    
The Difficulties Faced: 
                        Managing time over all the modules of the project was difficult due some personal circumstances. I should have given more time to the 
                        implementation of the functionalities first instead of visual design. 
                        
                       
                                                            
                                
                                

                    
            
            
