using System.Diagnostics;
using System.Net.Http.Headers;
using System.Text;
using SpotifyAPI.Web;

namespace backend;

public class SpotifyAPI
{
    private static SpotifyClient? _instance;
    private static string _verifier;
    private static AuthorizationCodeTokenResponse _response;
    private static PKCEAuthenticator _authenticator;
    private static SpotifyClientConfig _config;
    private static string _clientId = "1d6a111ca15a48a5a5b1f0364147756f";
    private static string _clientSecret = "8be78aee41254eef8332c6605344a4cb";

    private SpotifyAPI()
    {
    }

    public static void CreateInstance()
    {
        if (_instance is null)
        {
            // Login();
            // var config = SpotifyClientConfig.CreateDefault().WithAuthenticator(
            //     new ClientCredentialsAuthenticator("1d6a111ca15a48a5a5b1f0364147756f",
            //         "8be78aee41254eef8332c6605344a4cb"));
            //
            // _instance = new SpotifyClient(config);
            // Note that we use the verifier calculated above!

            _instance = new SpotifyClient(_config);
            
        }
    }

    public static SpotifyClient GetInstance()
    {
        if (_instance is null)
        {
            // Login();
            // var config = SpotifyClientConfig.CreateDefault().WithAuthenticator(
            //     new ClientCredentialsAuthenticator("1d6a111ca15a48a5a5b1f0364147756f",
            //         "8be78aee41254eef8332c6605344a4cb"));
            //
            // _instance = new SpotifyClient(config);
            // Note that we use the verifier calculated above!

            CreateInstance();
        }

        return _instance;
    }

    public static async Task Initiate(string code)
    {
        // _response = await new OAuthClient().RequestToken(
        //     new PKCETokenRequest("1d6a111ca15a48a5a5b1f0364147756f", code,
        //         new Uri("http://localhost:5173/callback"), _verifier)
        // );
        //
        // _authenticator = new PKCEAuthenticator("1d6a111ca15a48a5a5b1f0364147756f", _response);
        // _config = SpotifyClientConfig.CreateDefault()
        //     .WithAuthenticator(_authenticator);
        //
        // Console.WriteLine(code);
        _response = await new OAuthClient().RequestToken(
            new AuthorizationCodeTokenRequest("1d6a111ca15a48a5a5b1f0364147756f", "8be78aee41254eef8332c6605344a4cb",
                code, new Uri("http://localhost:5173/callback"))
        );
        
        var requestData = new Dictionary<string, string>
        {
            {"grant_type", "authorization_code"},
            {"code", code},
            {"redirect_uri", "http://localhost:5173/callback"}
        };
        var requestBody = new FormUrlEncodedContent(requestData);
        var request = new HttpRequestMessage(HttpMethod.Post, "https://accounts.spotify.com/api/token")
        {
            Content = requestBody
        };

        HttpClient Client = new();
        Client.BaseAddress = new Uri("https://api.spotify.com/");
        Client.DefaultRequestHeaders.Accept.Clear();
        Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

        var credentials = Convert.ToBase64String(Encoding.UTF8.GetBytes($"{_clientId}:{_clientSecret}"));
        Client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Basic", credentials);

        using HttpResponseMessage response = await Client.SendAsync(request);

        AuthorizationCodeTokenResponse initialToken =
            await response.Content.ReadAsAsync<AuthorizationCodeTokenResponse>();
        _config = SpotifyClientConfig
            .CreateDefault()
            .WithAuthenticator(new AuthorizationCodeAuthenticator("1d6a111ca15a48a5a5b1f0364147756f",
                "8be78aee41254eef8332c6605344a4cb", initialToken));
    }

    public static void Login()
    {
        // Generates a secure random verifier of length 100 and its challenge
        (_verifier, var challenge) = PKCEUtil.GenerateCodes();

        var loginRequest = new LoginRequest(
            new Uri("http://localhost:5173/callback"),
            "1d6a111ca15a48a5a5b1f0364147756f",
            LoginRequest.ResponseType.Code
        )
        {
            Scope = new[]
            {
                Scopes.PlaylistReadPrivate, Scopes.PlaylistReadCollaborative, Scopes.UserReadEmail,
                Scopes.UserReadPrivate
            },
        };
        var uri = loginRequest.ToUri();

        // Redirect user to uri via your favorite web-server or open a local browser window
        Process.Start(new ProcessStartInfo {FileName = uri.AbsoluteUri, UseShellExecute = true});
    }

    // // This method should be called from your web-server when the user visits "http://localhost:5000/callback"
    // // TODO: maybe call this from the frontend code which will have a page on the redirect uri
    // public static async Task GetCallback(string code, string verifier)
    // {
    //     // Note that we use the verifier calculated above!
    //     var initialResponse = await new OAuthClient().RequestToken(
    //         new PKCETokenRequest("ClientId", code, new Uri("http://localhost:5173/callback"), verifier)
    //     );
    //
    //     var authenticator = new PKCEAuthenticator("1d6a111ca15a48a5a5b1f0364147756f", initialResponse);
    //
    //     var config = SpotifyClientConfig.CreateDefault()
    //         .WithAuthenticator(authenticator);
    //     var spotify = new SpotifyClient(config);
    //     Console.Write(spotify);
    // }
}