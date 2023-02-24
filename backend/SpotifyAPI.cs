using System.Diagnostics;
using System.Net;
using SpotifyAPI.Web;

namespace backend;

public class SpotifyAPI
{
    private static SpotifyClient? _instance;

    private SpotifyAPI()
    {
    }

    public static SpotifyClient GetInstance()
    {
        if (_instance is null)
        {
            Login();
            var config = SpotifyClientConfig.CreateDefault().WithAuthenticator(
                new ClientCredentialsAuthenticator("1d6a111ca15a48a5a5b1f0364147756f",
                    "8be78aee41254eef8332c6605344a4cb"));

            _instance = new SpotifyClient(config);
        }

        return _instance;
    }

    public static void Login()
    {
        // Generates a secure random verifier of length 100 and its challenge
        var (verifier, challenge) = PKCEUtil.GenerateCodes();

        // Make sure "http://localhost:5000/callback" is in your applications redirect URIs!
        var loginRequest = new LoginRequest(
            new Uri("http://localhost:5173/callback"),
            "1d6a111ca15a48a5a5b1f0364147756f",
            LoginRequest.ResponseType.Code
        )
        {
            CodeChallengeMethod = "S256",
            CodeChallenge = challenge,
            Scope = new[] {Scopes.PlaylistReadPrivate, Scopes.PlaylistReadCollaborative}
        };
        var uri = loginRequest.ToUri();
        
        // Redirect user to uri via your favorite web-server or open a local browser window
        Process.Start(new ProcessStartInfo { FileName = uri.AbsoluteUri, UseShellExecute = true });

    }
    
    // This method should be called from your web-server when the user visits "http://localhost:5000/callback"
    // TODO: maybe call this from the frontend code which will have a page on the redirect uri
    public static async Task GetCallback(string code, string verifier)
    {
        // Note that we use the verifier calculated above!
        var initialResponse = await new OAuthClient().RequestToken(
            new PKCETokenRequest("ClientId", code, new Uri("http://localhost:5173/callback"), verifier)
        );
    
        var authenticator = new PKCEAuthenticator("1d6a111ca15a48a5a5b1f0364147756f", initialResponse);
    
        var config = SpotifyClientConfig.CreateDefault()
            .WithAuthenticator(authenticator);
        var spotify = new SpotifyClient(config);
        Console.Write(spotify);
    }
}