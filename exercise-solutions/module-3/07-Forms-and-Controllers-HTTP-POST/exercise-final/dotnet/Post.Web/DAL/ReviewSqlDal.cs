using Post.Web.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace Post.Web.DAL
{
    public class ReviewSqlDal : IReviewDAL
    {
        private readonly string connectionString;

        public ReviewSqlDal(string connectionString)
        {
            this.connectionString = connectionString;
        }

        /// <summary>
        /// Returns a list of all reviews
        /// </summary>
        /// <returns></returns>
        public IList<Review> GetAllReviews()
        {
            List<Review> output = new List<Review>();
            try
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    conn.Open();

                    SqlCommand cmd = new SqlCommand("SELECT * FROM reviews", conn);
                    SqlDataReader reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        output.Add(new Review()
                        {
                            Id = Convert.ToInt32(reader["review_id"]),
                            Username = Convert.ToString(reader["username"]),
                            Rating = Convert.ToInt32(reader["rating"]),
                            Title = Convert.ToString(reader["review_title"]),
                            Message = Convert.ToString(reader["review_text"]),
                            ReviewDate = Convert.ToDateTime(reader["review_date"])
                        });
                    }
                }
            }
            catch (SqlException ex)
            {
                throw;
            }

            return output;
        }

        /// <summary>
        /// Saves a new review to the system.
        /// </summary>
        /// <param name="newReview"></param>
        /// <returns></returns>
        public int SaveReview(Review newReview)
        {
            try
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    conn.Open();

                    SqlCommand cmd = new SqlCommand("INSERT INTO reviews VALUES (@username, @rating, @title, @message, getdate());", conn);
                    cmd.Parameters.AddWithValue("@username", newReview.Username);
                    cmd.Parameters.AddWithValue("@rating", newReview.Rating);
                    cmd.Parameters.AddWithValue("@title", newReview.Title);
                    cmd.Parameters.AddWithValue("@message", newReview.Message);

                    cmd.ExecuteNonQuery();

                    cmd = new SqlCommand("SELECT MAX(review_id) FROM reviews;", conn);
                    int newId = Convert.ToInt32(cmd.ExecuteScalar());

                    return newId;
                }
            }
            catch (SqlException ex)
            {
                throw;
            }
        }
    }
}
